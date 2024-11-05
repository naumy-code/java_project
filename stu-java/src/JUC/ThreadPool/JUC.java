public class JucTest {
    static int nuumber = 17;
    static StampedLock stampedLock = new StampedLock();
    public void write() {
        System.out.println(Thread.currentThread().getName() + "\t" + "wirte thread prepare to wirte");
        long stamp = stampedLock.writeLock();
        try {
            nuumber = nuumber + 13;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
        System.out.println(Thread.currentThread().getName() + "\t" + "wirte thread end to wirte");
    }
    //悲观读
    public void read() {
        System.out.println(Thread.currentThread().getName() + "\t" + "wirte thread prepare to read");
        long stamp = stampedLock.readLock();
        for (int i = 0; i < 4; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("reading...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            int result = nuumber;
            System.out.println("read: " + result);
        } finally {
            stampedLock.unlockRead(stamp);
        }
        System.out.println(Thread.currentThread().getName() + "\t" + "wirte thread end to read");
    }
    //乐观读
    public void tryOptimisticRead() {
        long stamp = stampedLock.tryOptimisticRead();
        int result = nuumber;
        System.out.println("判断是否有修改" + "\t" + stampedLock.validate(stamp));
        for (int i = 0; i < 4; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("reading stampedLockValidate: " + stampedLock.validate(stamp));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!stampedLock.validate(stamp)) {
            System.out.println("value modified by someone");
            stamp = stampedLock.readLock();
            try {
                System.out.println("乐观读升级为悲观读");
                result = nuumber;
                System.out.println("悲观读后: " + result);
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }
        System.out.println("finally value: " + result);
    }
    public static void main(String[] args) {
        JucTest jucTest = new JucTest();
        new Thread(() -> {
            jucTest.tryOptimisticRead();
        }, "readThread").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            jucTest.write();
        }, "writeThread").start();
        System.out.println(Thread.currentThread().getName() + "\t" + nuumber);
    }
}