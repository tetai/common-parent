package cn.zkz.common.generate;

import cn.zkz.common.generate.core.CodeGenerate;
import lombok.SneakyThrows;

/**
 * @Desc
 * @Author zkz
 * @Date 2021/12/16
 */
public class Start {

    @SneakyThrows
    public static void main(String[] args) throws Exception {
        CodeGenerate.codeGenerate();
    }
}
