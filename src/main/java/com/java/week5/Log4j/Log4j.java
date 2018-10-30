package com.java.week5.Log4j;

import org.apache.log4j.Logger;

//Log4j class
public class Log4j {


        final static Logger logger = Logger.getLogger(Log4j.class);
        public static void main(String[] args)
        {
            logger.trace("Trace Message!");
            logger.debug("Debug Message");
            logger.info("Info Message");
            logger.warn("Warn Message");
            logger.error("Error Message");
            logger.fatal("Fatal Message");
        }
    }



