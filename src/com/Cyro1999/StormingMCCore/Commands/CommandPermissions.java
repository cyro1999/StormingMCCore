package com.Cyro1999.StormingMCCore.Commands;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CommandPermissions
{
    SourceType source();

    boolean block_Host_Console() default false;
}

