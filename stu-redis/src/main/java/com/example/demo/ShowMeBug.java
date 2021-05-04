package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ShowMeBug {

    /**
     * 现在程序中有一组医生排班数据，每条数据为某个医生的某天的某个时间的排班。
     * 要求对这组数据进行数据转换和处理，转换成排班表格，表格通过控制台输出即可。
     * 要求表头按照时间排序。如果某天没有排班，则表格不展示该列。某天某时间无数据则显示无排班。
     * 上午下午晚上通过Vo中的seqNo排序。
     * eg:
     * 	      2020-05-31 2020-06-01	2020-06-02 2020-06-04
     * 上午	 李四       赵六	   张三	     无排班
     * 下午	 赵六       张三	   赵六	     张三
     * 晚上	 孙七	      张三	   无排班	    张三
     * 需要注意的是，最终完成代码的代码质量（逻辑是否清晰，变量/方法命名是否合理等），将作为考察标准的一部分
     */

    public static void main(String[] args) {
        // TODO: 打印出所有排班信息
        List<TimeRangeVo> timeRangeVoList = getTimeRangeVoList();
        List<SchemaVo> schemaVoList = getSchemaVoList();
        String distinct = schemaVoList.stream().map(SchemaVo::getSchemaDate).distinct().toString();
        System.out.println(distinct);

    }

    public static List<TimeRangeVo> getTimeRangeVoList() {
        List<TimeRangeVo> timeRangeVoList = new ArrayList<TimeRangeVo>();
        timeRangeVoList.add(new TimeRangeVo("下午", 3));
        timeRangeVoList.add(new TimeRangeVo("中午", 2));
        timeRangeVoList.add(new TimeRangeVo("上午", 1));
        timeRangeVoList.add(new TimeRangeVo("晚上", 4));

        return timeRangeVoList;
    }

    public static List<SchemaVo> getSchemaVoList() {
        List<SchemaVo> schemaVoList = new ArrayList<SchemaVo>();

        schemaVoList.add(new SchemaVo("王五", "下午", "2020-06-04"));
        schemaVoList.add(new SchemaVo("张三", "上午", "2020-06-02"));
        schemaVoList.add(new SchemaVo("赵六", "下午", "2020-06-01"));
        schemaVoList.add(new SchemaVo("李四", "下午", "2020-06-01"));
        schemaVoList.add(new SchemaVo("王五", "下午", "2020-05-31"));
        schemaVoList.add(new SchemaVo("王五", "下午", "2020-06-01"));
        schemaVoList.add(new SchemaVo("李四", "下午", "2020-06-02"));
        schemaVoList.add(new SchemaVo("李四", "下午", "2020-06-04"));
        schemaVoList.add(new SchemaVo("孙七", "晚上", "2020-06-04"));
        schemaVoList.add(new SchemaVo("张三", "下午", "2020-05-31"));
        schemaVoList.add(new SchemaVo("赵六", "晚上", "2020-06-01"));
        schemaVoList.add(new SchemaVo("张三", "晚上", "2020-06-04"));
        schemaVoList.add(new SchemaVo("李四", "上午", "2020-05-31"));
        schemaVoList.add(new SchemaVo("赵六", "上午", "2020-06-01"));
        schemaVoList.add(new SchemaVo("张三", "下午", "2020-06-01"));
        schemaVoList.add(new SchemaVo("赵六", "下午", "2020-05-31"));
        schemaVoList.add(new SchemaVo("张三", "下午", "2020-06-02"));
        schemaVoList.add(new SchemaVo("王五", "上午", "2020-05-31"));
        schemaVoList.add(new SchemaVo("孙七", "晚上", "2020-05-31"));
        schemaVoList.add(new SchemaVo("张三", "晚上", "2020-06-01"));

        return schemaVoList;
    }

    static class TimeRangeVo {
        String timeRangeDesc;
        int seqNo;

        public TimeRangeVo(String timeRangeDesc, int seqNo){
            this.timeRangeDesc = timeRangeDesc;
            this.seqNo = seqNo;
        }

        public String getTimeRangeDesc() {
            return timeRangeDesc;
        }

        public void setTimeRangeDesc(String timeRangeDesc) {
            this.timeRangeDesc = timeRangeDesc;
        }

        public int getSeqNo() {
            return seqNo;
        }

        public void setSeqNo(int seqNo) {
            this.seqNo = seqNo;
        }
    }

    static class SchemaVo {
        public String doctorName;
        public String timeRangeDesc;
        public String schemaDate;

        public SchemaVo(String doctorName, String timeRangeDesc, String schemaDate) {
            this.doctorName = doctorName;
            this.timeRangeDesc = timeRangeDesc;
            this.schemaDate = schemaDate;
        }

        public String getDoctorName() {
            return doctorName;
        }

        public void setDoctorName(String doctorName) {
            this.doctorName = doctorName;
        }

        public String getTimeRangeDesc() {
            return timeRangeDesc;
        }

        public void setTimeRangeDesc(String timeRangeDesc) {
            this.timeRangeDesc = timeRangeDesc;
        }

        public String getSchemaDate() {
            return schemaDate;
        }

        public void setSchemaDate(String schemaDate) {
            this.schemaDate = schemaDate;
        }
    }
}
