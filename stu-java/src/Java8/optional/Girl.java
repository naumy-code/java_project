package Java8.optional;

/**
 * @author Administrator
 */
public class Girl {

    private String name;

    private int age;

    public Girl(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public Girl() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}