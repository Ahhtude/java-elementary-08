package org.demo.birds.processor;

import org.demo.birds.entities.Bird;
import org.demo.birds.store.BirdStore;


import java.util.Scanner;

/**
 * Реализовать интерфейсы IBirdCreator, IUserCommandProcessor, IInfiniteLoopProcessor
 */
public class UserCommandProcessor  implements IBirdCreator,IInfiniteLoopProcessor,IUserCommandProcessor {
    Scanner scanner = new Scanner(System.in);

    @Override
    public Bird createBird(Scanner userInputReader) {
        System.out.println("Please, enter bird name: ");
        String name = scanner.nextLine();
        System.out.println("Please, enter bird living area:");
        String livingArea = scanner.nextLine();
        System.out.println("Please, enter bird size:");
        double birdSize = scanner.nextDouble();
        return new Bird(name,livingArea,birdSize);
    }

    @Override
    public void processInLoop() {
        while (true){
            System.out.print("Please, enter command: \n" +
                    " a - add new Bird \n " +
                    "s - search bird by name \n" +
                    " l - search bird by living area \n" +
                    " exit - terminate application \n");
            String commandInLoop = scanner.nextLine();
            processUserCommand(commandInLoop,scanner);
        }
    }

    @Override
    public void processUserCommand(String command, Scanner userInputReader) {
        if (command=="a"){
        BirdStore.getSingtoneBirdStore().addBird(createBird(scanner));
        }
        else if (command == "s"){
            System.out.println("Please, enter bird living area to search: ");
            BirdStore.getSingtoneBirdStore().searchByLivingArea(scanner.nextLine().toLowerCase());
        }
        else if (command == "l"){
            System.out.println("Please, enter bird living area to search: ");
            BirdStore.getSingtoneBirdStore().searchByName(scanner.nextLine().toLowerCase());
        }
        else System.out.println("Unknown command.");
        }
    }
