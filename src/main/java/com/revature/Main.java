package com.revature;

import com.revature.controller.Controller;

/**
 * Create an instance of your controller and launch your application.
 * 
 * Try not to have any logic at all on this class.
 */
public class Main {

  public static void main(String[] args) {

    PrintWelcome();

    Controller.LogIn();

  }

  public static void PrintWelcome() {
    System.out.println("    ____                  __                ");
    System.out.println("   / __ \\___ _   ______ _/ /___  __________ ");
    System.out.println("  / /_/ / _ \\ | / / __ `/ __/ / / / ___/ _ \\");
    System.out.println(" / _, _/  __/ |/ / /_/ / /_/ /_/ / /  /  __/");
    System.out.println("/_/ |_|\\___/|___/\\__,_/\\__/\\__,_/_/   \\___/ \n");
    System.out.println("    ____              __   _            ");
    System.out.println("   / __ )____ _____  / /__(_)___  ____ _");
    System.out.println("  / __  / __ `/ __ \\/ //_/ / __ \\/ __ `/");
    System.out.println(" / /_/ / /_/ / / / / ,< / / / / / /_/ / ");
    System.out.println("/_____/\\__,_/_/ /_/_/|_/_/_/ /_/\\__, /  ");
    System.out.println("                               /____/   ");
    System.out.println("    ____          ");
    System.out.println("   /  _/___  _____");
    System.out.println("   / // __ \\/ ___/");
    System.out.println(" _/ // / / / /___ ");
    System.out.println("/___/_/ /_/\\___(_)\n");

  }
}
