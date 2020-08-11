
package com.lj.cmml.common.utils;

import com.lj.cmml.common.Constants;
import com.lj.cmml.common.enums.DataType;
import com.lj.cmml.common.utils.placeholder.PlaceholderUtils;
import com.lj.cmml.common.utils.placeholder.TimePlaceholderUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

/**
 * parameter parse utils
 */
public class ParameterUtils {

    private static final Logger logger = LoggerFactory.getLogger(ParameterUtils.class);

    /**
     * convert parameters place holders
     *
     * @param parameterString parameter
     * @param parameterMap    parameter map
     * @return convert parameters place holders
     */
    public static String convertParameterPlaceholders(String parameterString, Map<String, String> parameterMap) {
        if (StringUtils.isEmpty(parameterString)) {
            return parameterString;
        }

        //Get current time, schedule execute time
        String cronTimeStr = parameterMap.get(Constants.PARAMETER_DATETIME);

        Date cronTime = null;

        if (StringUtils.isNotEmpty(cronTimeStr)) {
            try {
                cronTime = DateUtils.parseDate(cronTimeStr, new String[]{Constants.PARAMETER_FORMAT_TIME});
            } catch (ParseException e) {
                logger.error(String.format("parse %s exception", cronTimeStr), e);
            }
        } else {
            cronTime = new Date();
        }

        // replace variable ${} form,refers to the replacement of system variables and custom variables
        parameterString = PlaceholderUtils.replacePlaceholders(parameterString, parameterMap, true);

        // replace time $[...] form, eg. $[yyyyMMdd]
        if (cronTime != null) {
            parameterString = TimePlaceholderUtils.replacePlaceholders(parameterString, cronTime, true);
        }

        return parameterString;
    }

    /**
     * set in parameter
     *
     * @param index    index
     * @param stmt     preparedstatement
     * @param dataType data type
     * @param value    value
     * @throws Exception errors
     */
    public static void setInParameter(int index, PreparedStatement stmt, DataType dataType, String value) throws Exception {
        if (dataType.equals(DataType.VARCHAR)) {
            stmt.setString(index, value);
        } else if (dataType.equals(DataType.INTEGER)) {
            stmt.setInt(index, Integer.parseInt(value));
        } else if (dataType.equals(DataType.LONG)) {
            stmt.setLong(index, Long.parseLong(value));
        } else if (dataType.equals(DataType.FLOAT)) {
            stmt.setFloat(index, Float.parseFloat(value));
        } else if (dataType.equals(DataType.DOUBLE)) {
            stmt.setDouble(index, Double.parseDouble(value));
        } else if (dataType.equals(DataType.DATE)) {
            stmt.setString(index, value);
        } else if (dataType.equals(DataType.TIME)) {
            stmt.setString(index, value);
        } else if (dataType.equals(DataType.TIMESTAMP)) {
            stmt.setString(index, value);
        } else if (dataType.equals(DataType.BOOLEAN)) {
            stmt.setBoolean(index, Boolean.parseBoolean(value));
        }
    }

    /**
     * handle escapes
     *
     * @param inputString input string
     * @return string filter escapes
     */
    public static String handleEscapes(String inputString) {

        if (StringUtils.isNotEmpty(inputString)) {
            return inputString.replace("%", "////%");
        }
        return inputString;
    }
}
