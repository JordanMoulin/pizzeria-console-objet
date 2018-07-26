package fr.Pizzeria.Utils;

import java.lang.reflect.Field;
import java.text.DecimalFormat;

import fr.Pizzeria.Model.Pizza;

public class StringUtils {
	public static String format (double d, String format) {
		DecimalFormat ff = new DecimalFormat(format);
		return ff.format(d);
	}
//	public static String toString() {
//		String chaine = "";
//		String upperChaine = "";
//		Class structure = Pizza;
//		Field[] fields = structure.getDeclaredFields();
//		for(Field field: fields){
//			if (field.isAnnotationPresent(ToString.class)){
//				ToString annotation = field.getAnnotation(ToString.class);
//				String apres = annotation.apres();
//				String avant = annotation.avant();
//				boolean a = annotation.uppercase();
//				try {
//					if(a){
//						upperChaine = (String) field.get(this);
//						upperChaine = upperChaine.toUpperCase();
//						chaine+=avant+upperChaine+apres;
//					}else{
//						chaine+=avant+field.get(this)+apres;
//					}
//				} catch (IllegalArgumentException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IllegalAccessException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		return chaine;
//	}
}
