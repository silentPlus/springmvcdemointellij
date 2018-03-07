package com.suvan.beancopy;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;

/**
 * Created by suvan on 2017/12/14.
 */
public class BeanCopierConverterTest {
    private static final BeanCopier beanCopier = BeanCopier.create(SourceBean.class, DesBean.class, true);

    public static void main(String[] args) {
        SourceBean sourceBean = new SourceBean(10, "abc", "source", false, "34");
        BeanCopierConverter converter = new BeanCopierConverter();
        DesBean desBean = new DesBean();
        beanCopier.copy(sourceBean, desBean, converter);
        System.out.println(sourceBean.toString());
        System.out.println(desBean.toString());
    }

    static class BeanCopierConverter implements Converter {

        @Override
        public Object convert(Object value, Class target, Object context) {
            if (target == Integer.class) {
                return Integer.valueOf(value.toString());
            } else if (target == String.class) {
                return value.toString();
            } else if (target == Boolean.class) {
                return Boolean.valueOf(value.toString());
            }

            return null;
        }
    }
}

