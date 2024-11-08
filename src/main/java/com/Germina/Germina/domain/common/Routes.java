package com.Germina.Germina.domain.common;

public class Routes {
    public static final String API ="api/";

    public static class TempUser {
        public static final String TempUser = "TempUser";
        public static final String getTempUser = "getTempUser";
        public static final String saveTempUser = "saveTempUser";
        public static final String deleteTempUser = "deleteTempUser";
    }

    public static class ConfigHr{
        public static final String ConfigHr = "ConfigHr";
        public static final String actConfigHr = "actConfigHr";
    }

    public static class Dish{
        public static final String Dish = "Dish";
        public static final String getDish = "getDish";
        public static final String saveDish = "saveDish";
        public static final String updateDish = "uptDish";
        public static final String inactivateDish = "inctDish";
    }
}
