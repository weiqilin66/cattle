package org.wayne.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: lwq
 */
public class UtilsQ {
    final static SimpleDateFormat YYYY_MM_DD_FORMAT;
    final static SimpleDateFormat MM_DD_FORMAT;

    static {
        YYYY_MM_DD_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        //严格日期检查
        YYYY_MM_DD_FORMAT.setLenient(false);
        MM_DD_FORMAT = new SimpleDateFormat("MM-dd");
        MM_DD_FORMAT.setLenient(false);

    }

    /**
     * 获取下一个工作日
     *
     * @param dataDay     当天
     * @param freeDayList 休息日集合
     */
    public static String getNextWorkDay(String dataDay, List<String> freeDayList) throws ParseException {
        dataDay = addOrSubDay(dataDay, 1);
        //休息日
        while (freeDayList.contains(dataDay)) {
            dataDay = addOrSubDay(dataDay, 1);
        }
        return dataDay;
    }

    /**
     * 两个日期间隔天数
     *
     * @param minDate
     * @param bigDate
     */
    public static int getBetweenDayCounts(String minDate, String bigDate) throws ParseException {
        final Date p1 = YYYY_MM_DD_FORMAT.parse(bigDate);
        final Date p2 = YYYY_MM_DD_FORMAT.parse(minDate);
        return (int) (Math.abs(p1.getTime() - p2.getTime()) / (60 * 60 * 24 * 1000));
    }

    /**
     * 日期加减
     *
     */
    public static String addOrSubDay(String date, int count) throws ParseException {
        final Date parse = YYYY_MM_DD_FORMAT.parse(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parse);
        calendar.add(Calendar.DAY_OF_MONTH, count);
        return YYYY_MM_DD_FORMAT.format(calendar.getTime());
    }

    public static Date addOrSubDay(Date date, int count) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, count);
        return calendar.getTime();
    }

    /**
     * 获取2个日期之间的日期数组
     *
     */
    public static List<Date> getBetweenDayArray(Date start, Date end) {
        List<Date> dates = new ArrayList<>();
        dates.add(start);
        if (start.compareTo(end) == 0) {
            return dates;
        }
        while (true) {
            start = addOrSubDay(start, 1);
            if (start.after(end) || start.compareTo(end) == 0) {
                break;
            }
            dates.add(start);
        }
        dates.add(end);
        return dates;
    }

    public static List<String> getBetweenDayArray(String start, String end) throws ParseException {
        List<String> dates = new ArrayList<>();
        dates.add(start);
        if (dates.contains(end)) {
            return dates;
        }
        while (true) {
            start = addOrSubDay(start, 1);
            if (YYYY_MM_DD_FORMAT.parse(start).after(YYYY_MM_DD_FORMAT.parse(end)) || start.equals(end)) {
                break;
            }
            dates.add(start);
        }
        dates.add(end);
        return dates;
    }

    public static boolean isEmptyStr(String s) {
        return s == null || s.length() == 0;
    }

    /**
     * @TODO 快速比较两个String集合的差异
     * 利用map快速定位key是否存在的特性
     * @date 2020/5/12
     */
    private static List<String> getDiffList(List<String> listA, List<String> listB) {
        if (listB != null && !listB.isEmpty()) {
            Map<String, String> dataMap = new HashMap<String, String>();
            for (String id : listB) {
                dataMap.put(id, id);
            }

            List<String> newList = new ArrayList<String>();
            for (String id : listA) {
                if (!dataMap.containsKey(id)) {
                    newList.add(id);
                }
            }
            return newList;
        } else {
            return listA;
        }
    }

    //下划线命名转为驼峰命名
    public static String ToCamel(String param) {
        StringBuilder result = new StringBuilder();
        String arr[] = param.split("_");
        for (String s : arr) {
            // 传入的值不包含_ 返回原值
            if (!param.contains("_")) {
                result.append(s);
                continue;
            }
            if (result.length() == 0) {
                result.append(s.toLowerCase());
            } else {
                // 字符大写
                result.append(s.substring(0, 1).toUpperCase());
                // 余下小写
                result.append(s.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    //驼峰命名转为下划线命名
    public static String ToSqlStyle(String para) {
        StringBuilder sb = new StringBuilder(para);
        int temp = 0;//定位
        if (!para.contains("_")) {
            for (int i = 0; i < para.length(); i++) {
                if (Character.isUpperCase(para.charAt(i))) {
                    sb.insert(i + temp, "_");
                    temp += 1;
                }
            }
        }
        return sb.toString().toUpperCase();
    }

    /**
     * @param 提示内容
     * @return java.lang.String
     * @TODO 入参为提问 并返回下一行控制器输入的值
     * @date 2020/1/7
     */
    public static String sc(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        str.append("请输入" + tip + "：");
        System.out.println(str.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (!UtilsQ.isEmptyStr(ipt)) {
                return ipt;
            }
        }
        return null;
    }

    /**
     * 将入参的list超过reSize条的 拆分为多个list,最大的为reSize
     * 批量更新 批量插入等操作用到
     *
     * @param list reSize
     * @return
     */
    public static <T> List<List<T>> reSize(List<T> source, int reSize) {
        List<List<T>> result = new ArrayList();
        if (source == null) {
            return null;
        } else {
            int size = source.size();
            if (size <= reSize) {
                result.add(source);
                return result;
            } else {
                for (int i = 0; i < source.size(); i += reSize) {
                    result.add(source.subList(i, Math.min(i + reSize, size)));
                }

                return result;
            }
        }
    }
}
