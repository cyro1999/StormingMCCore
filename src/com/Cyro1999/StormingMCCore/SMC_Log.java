package com.Cyro1999.StormingMCCore;

import java.util.logging.Level;
import java.util.logging.Logger;

// Credits to Madgeek and Darth

public class SMC_Log
{
    private static final Logger logger = Logger.getLogger("Minecraft-Server");

    private SMC_Log()
    {
        throw new AssertionError();
    }

    private static void log(Level level, String message, boolean raw)
    {
        logger.log(level, (raw ? "" : "[StormingMCCore]: ") + message);
    }

    public static void info(String message)
    {
        SMC_Log.info(message, false);
    }

    public static void info(String message, boolean raw)
    {
        SMC_Log.log(Level.INFO, message, raw);
    }

    public static void warning(String message)
    {
        SMC_Log.info(message, false);
    }

    public static void warning(String message, boolean raw)
    {
        SMC_Log.log(Level.WARNING, message, raw);
    }

    public static void severe(String message)
    {
        SMC_Log.info(message, false);
    }

    public static void severe(String message, boolean raw)
    {
        SMC_Log.log(Level.SEVERE, message, raw);
    }

    public static void severe(Throwable ex)
    {
        logger.log(Level.SEVERE, null, ex);
    }
}