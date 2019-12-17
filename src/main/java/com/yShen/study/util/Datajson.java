package com.yShen.study.util;

public class Datajson {

    private Integer code=0;
    private String msg="";
    private Long count;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Datajson{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
    public Datajson() {
    }

    public Datajson(Integer code, String msg, Long count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public Datajson(String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }

    public Datajson(Object data) {
        this.data = data;
    }

    public Datajson(String msg) {
        this.msg = msg;
    }

    public Datajson(Integer code) {
        this.code = code;
    }

    public Datajson(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
