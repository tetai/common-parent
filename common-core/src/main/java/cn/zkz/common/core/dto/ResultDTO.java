package cn.zkz.common.core.dto;



import java.io.Serializable;


public class ResultDTO<T> implements Serializable {

    private static final long serialVersionUID = -3430603013914181383L;
    private Integer code;

    private String msg;

    protected T data;

    private Boolean success;

    public ResultDTO() {
    }


    public ResultDTO(int code, T data, String msg) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    private ResultDTO(int resultCode, String msg) {
        this.code = resultCode;
        this.msg = msg;
    }

    public ResultDTO(ResultDTO resultDTO) {
        this.code = resultDTO.getCode();
        this.msg = resultDTO.getMsg();
    }


    public static <T> ResultDTO<T> fail(int code, String msg) {
        return new ResultDTO(code, msg);
    }

    public static <T> ResultDTO<T> fail(int code,T data,String msg) {
        return new ResultDTO(code,data,msg);
    }

    public String getMsg() {
        return msg;
    }

    public ResultDTO setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResultDTO setCode(Integer code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResultDTO setData(T data) {
        this.data = data;

        return this;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return "ResultDTO{" + "core=" + code + ", msg='" + msg + '\'' + ", success=" + isSuccess() + ", data=" + data +
            '}';
    }
}
