package com.example.test004.config;

import lombok.extern.slf4j.Slf4j;

@Slf4j
 public class DatabaseContextHolder {
    private static final ThreadLocal<DB_TYPE> CONTEXT = new ThreadLocal<>();

    public static void set(DB_TYPE dbType) {
        CONTEXT.set(dbType);
    }

    public static DB_TYPE getDbType() {
        log.info("context type {}", (CONTEXT.get()==null? DB_TYPE.WRITE : DB_TYPE.READ).name());
        return CONTEXT.get()==null? DB_TYPE.WRITE : DB_TYPE.READ;
    }

    public static void reset() {
        CONTEXT.remove();
        log.info("context released (set to write)");
    }
}
