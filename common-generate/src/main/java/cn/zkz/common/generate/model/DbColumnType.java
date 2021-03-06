package cn.zkz.common.generate.model;

/**
 * @Desc
 * @Author zkz
 * @Date 2021/12/16
 */
public enum DbColumnType {
    BASE_INT("int", (String)null),
    BASE_BOOLEAN("boolean", (String)null),
    BASE_FLOAT("float", (String)null),
    BASE_DOUBLE("double", (String)null),
    STRING("String", (String)null),
    LONG("Long", (String)null),
    INTEGER("Integer", (String)null),
    FLOAT("Float", (String)null),
    DOUBLE("Double", (String)null),
    BOOLEAN("Boolean", (String)null),
    BYTE_ARRAY("byte[]", (String)null),
    CHARACTER("Character", (String)null),
    OBJECT("Object", (String)null),
    DATE("Date", "java.util.Date"),
    TIME("Time", "java.sql.Time"),
    BLOB("Blob", "java.sql.Blob"),
    CLOB("Clob", "java.sql.Clob"),
    TIMESTAMP("Timestamp", "java.sql.Timestamp"),
    BIG_INTEGER("BigInteger", "java.math.BigInteger"),
    BIG_DECIMAL("BigDecimal", "java.math.BigDecimal"),
    LOCAL_DATE("LocalDate", "java.time.LocalDate"),
    LOCAL_TIME("LocalTime", "java.time.LocalTime"),
    LOCAL_DATE_TIME("LocalDateTime", "java.time.LocalDateTime");

    private final String type;
    private final String pkg;

    private DbColumnType(String type, String pkg) {
        this.type = type;
        this.pkg = pkg;
    }

    public String getType() {
        return this.type;
    }

    public String getPkg() {
        return this.pkg;
    }
}
