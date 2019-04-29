package org.demo.birds.processor;

import org.demo.birds.entities.Bird;
import org.demo.birds.store.BirdStore;


import java.util.Scanner;

/**
 * Реализовать интерфейсы IBirdCreator, IUserCommandProcessor, IInfiniteLoopProcessor
 */
public class UserCommandProcessor  implements IBirdCreator,IInfiniteLoopProcessor,IUserCommandProcessor {

    @Override
    public Bird createBird(Scanner userInputReader) {
        System.out.println("Please, enter bird name: ");
        String name = userInputReader.nextLine();
        System.out.println("Please, enter bird living area:");
        String livingArea = userInputReader.nextLine();
        System.out.println("Please, enter bird size:");
        double birdSize = userInputReader.nextDouble();
        return new Bird(name,livingArea,birdSize);

    }

    @Override
    public void processInLoop() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Please, enter command: \n" +
                    " a - add new Bird \n " +
                    "s - search bird by name \n" +
                    " l - search bird by living area \n" +
                    " exit - terminate application \n");
            processUserCommand(scanner.nextLine(),scanner);
        }
    }

    @Override
    public void processUserCommand(String command, Scanner userInputReader) {

        if (command.equals("a")){
        BirdStore.getSingltoneBirdStore().addBird(createBird(userInputReader));
        }

        else if (command.equals("s")){
            System.out.println("Please, enter bird name to search: ");
            System.out.println(
            BirdStore.getSingltoneBirdStore().searchByName(userInputReader.nextLine()).getName() + " was find in BirdStore");

        }
        else if (command.equals("l")){
            System.out.println("Please, enter bird living area to search: ");
            BirdStore.getSingltoneBirdStore().searchByLivingArea(userInputReader.nextLine())
                    .forEach(a->{
                System.out.println(a.toString() + "Was find by living areas search");
            });
        }
        else System.out.println("Unknown command.");
        }
    }
