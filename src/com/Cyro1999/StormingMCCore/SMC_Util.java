package com.Cyro1999.StormingMCCore;

import java.lang.reflect.Field;
import org.bukkit.ChatColor;

public class SMC_Util {
    
    public static String colorize(String string)
    {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T getField(Object from, String name) {
        Class<?> checkClass = from.getClass();
        do
        {
            try
            {
                Field field = checkClass.getDeclaredField(name);
                field.setAccessible(true);
                return (T) field.get(from);

            }
            catch (NoSuchFieldException ex)
            {
            }
            catch (IllegalAccessException ex)
            {
            }
        }
        while (checkClass.getSuperclass() != Object.class
                && ((checkClass = checkClass.getSuperclass()) != null));

        return null;
        
    }
    
}
