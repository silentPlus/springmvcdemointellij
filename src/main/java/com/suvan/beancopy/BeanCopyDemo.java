package com.suvan.beancopy;

import net.sf.cglib.beans.BeanCopier;

/**
 * Created by suvan on 2017/12/14.
 */
public class BeanCopyDemo {
    private static BeanCopier beanCopier = BeanCopier.create(SourceBean.class, DesBean.class, false);

    static void doCopy(Integer time, BeanCopy beanCopy, String type) throws Exception{
        long start = System.nanoTime();
        for (int j = 0; j < time; j++) {
            SourceBean sourceBean = new SourceBean(j, "source" + j, "abc", false);
            DesBean desBean = new DesBean();
            beanCopy.copy(sourceBean, desBean);
        }
        System.out.printf("执行%d次用时%d纳秒-----------------------%s%n", time, System.nanoTime() - start, type);
    }

    public static void main(String[] args) throws Exception{
        Integer[] times = {10000, 1000, 10};
        for (int i = 0; i < times.length; i++) {
            Integer time = times[i];
            /*doCopy(time, (x, y) -> PropertyUtils.copyProperties(y, x), "org.apache.commons.beanutils.PropertyUtils.copyProperties");
            doCopy(time, (x, y) -> BeanUtils.copyProperties(y, x), "org.apache.commons.beanutils.BeanUtils.copyProperties");
            doCopy(time, (x, y) -> beanCopier.copy(x, y, null), "net.sf.cglib.beans.BeanCopier.copy");
            doCopy(time, (x, y) -> {
                y.setEat(x.getEat());
                y.setTitle(x.getTitle());
                y.setAge(x.getAge());
            }, "getter/setter");*/
        }
    }

    interface BeanCopy {
        void copy(SourceBean from, DesBean to) throws Exception;
    }
}
