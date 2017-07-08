/**
 * 
 */
package com.raycloud.util.daogen;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * @author microboss
 *
 */
public class SqlType2Field {
	private final static Logger logger = Logger.getLogger(SqlType2Field.class);
	
	private static Map<Integer,String> sqlType2Field = new HashMap<Integer,String>();
	static {
		sqlType2Field.put(Types.VARCHAR, "String");
		sqlType2Field.put(Types.DATE, "Date");	//java.util.Date
		//mysql
		sqlType2Field.put(Types.BIT, "Byte");
		sqlType2Field.put(Types.TINYINT, "Byte");
		sqlType2Field.put(Types.SMALLINT, "Integer");
		sqlType2Field.put(Types.INTEGER, "Integer");
		sqlType2Field.put(Types.BIGINT, "Long");
		sqlType2Field.put(Types.REAL, "Float");
		sqlType2Field.put(Types.DOUBLE, "Double");
		
		sqlType2Field.put(Types.CHAR, "String");
		sqlType2Field.put(Types.LONGVARCHAR, "String");
		
		sqlType2Field.put(Types.BINARY, "Blob");	//java.sql.Blob
		sqlType2Field.put(Types.VARBINARY, "Blob");	//java.sql.Blob
		sqlType2Field.put(Types.LONGVARBINARY, "Blob");	//java.sql.Blob
		
		sqlType2Field.put(Types.TIME, "Date");	//java.util.Date
		sqlType2Field.put(Types.TIMESTAMP, "Date");	//java.util.Date
		//oracle
		sqlType2Field.put(Types.NUMERIC, "Long");
		sqlType2Field.put(Types.FLOAT, "BigDecimal");	//java.math.BigDecimal
		sqlType2Field.put(Types.DECIMAL, "BigDecimal");	//java.math.BigDecimal
		sqlType2Field.put(Types.CLOB, "Clob");	//java.sql.Clob
	}

	public static String mapJavaType(int sqltype) {
		String javaType = sqlType2Field.get(sqltype);
		if(StringUtils.isNotBlank(javaType)){
			return javaType;
		}else{
			logger.error("字段没有对应的Java类型，SQL_TYPE：" + sqltype);
			return "String";
		}
	}
}
