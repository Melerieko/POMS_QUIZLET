package com.example.poms_quizlet.config;

public class Level1_Config {

    public Level1_Config(){}

    public String[] questions = {
            "-",
            "-",
            "-",
            "-",
            "-",
            "-",
            "-",
            "-",
            "-",
            "-",
            "-"
};
    public String[][] choices = {
        {"23 июля 1937 года", "1 сентября 1939 года", "22 июня 1941 года", "22 августа 1941 года"},
        {"Соратники", "Друзья", "Союзники", "Товарищи"},
        {"США", "Советский Союз", "Япония", "Франция"},
            {"22 февраля 1941 года", "22 июня 1941 года", "23 июля 1941 года", "7 ноября 1941 года"},
            {"38 дней", "55 дня", "60 дней", "42 дня"},
            {"3 июля 1944 года", "4 июня 1944 года", "29 декабря 1943 года", "29 августа 1944 года"},
            {"11 августа 1940 года", "27 сентября 1940 года", "5 ноября 1940 года", "3 сентября 1940 года"},
            {"СССР", "Китай", "Великобритания", "Турция"},
            {"Нападение на Филлипины", "Атака на американский линкор \"Монтана\"", "Атака на Перл-Харбор", "Захват в плен американских солдат в Китае"},
            {"Португалия", "Швейцария", "Швеция", "Испания"},
            {"[...]", "[...]", "[...]", "[...]"}
        };
    public String[] correctAnswer = {
        "1 сентября 1939 года",
        "Союзники",
        "США",
            "22 июня 1941 года",
            "42 дня",
            "3 июля 1944 года",
            "27 сентября 1940 года",
            "Турция",
            "Атака на Перл-Харбор",
            "Испания",
            "/"
        };
    public String getQuestion(int a){
        return questions[a];
        }
    public String getchoice1(int a){
        return choices[a][0];
        }
    public String getchoice2(int a){
        return choices[a][1];
        }
    public String getchoice3(int a){
        return choices[a][2];
        }
    public String getchoice4(int a){
        return choices[a][3];
        }
    public String getCorrectAnswer(int a){
        return correctAnswer[a];
        }
}
