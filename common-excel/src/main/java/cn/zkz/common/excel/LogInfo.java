package cn.zkz.common.excel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @Desc 出错日志，最后根据这个写入Excel
 * @Author zkz
 * @Date 2021/12/22
 */
@Data
@AllArgsConstructor
public class LogInfo {

    /**
     * 哪一列
     */
    private String cellName;
    /**
     * 错误信息
     */
    private String log;


    public LogInfo setCell(String cell) {
        this.cellName = StringUtils.isEmpty(this.cellName) ? cell : this.cellName.concat(",").concat(cell);
        return this;
    }

    public LogInfo setInfo(String info) {
        this.log = StringUtils.isEmpty(this.log) ? info : this.log.concat(",").concat(info);
        return this;
    }


}
