package Assignments.5;
import java.util.ArrayList;
import java.util.Scanner;
import weiss.nonstandard.*;

public class UndoRedoStacks<AnyType extends Comparable<? super AnyType>> extends ListStack {
    public static void main(String[] args) {
        ListStack<String> undo = new ListStack<>();
        ListStack<String> redo = new ListStack<>();
        
        ArrayList<String> sentence = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Sentence: ");

        while(scan.hasNext()){
            sentence.add(scan.next());
        }

        while (true) {
            String command = scan.nextLine();
            if (command.equals("quit")) {
                break;
            } else if (command == "add") {
                sentence.add(scan.next());
                undo.push(scan.next());
                redo = new ListStack<>(); // Clear redo stack after add
            } else if (command == "delete") {
                if (!sentence.isEmpty()) {
                    undo.push(sentence.remove(sentence.size() - 1));
                    redo = new ListStack<>(); // Clear redo stack after delete
                }
            } else if (command == "print") {
                System.out.println("Sentence: " + String.join(" ", sentence));
            } else if (command == "undo") {
                if (!undo.isEmpty()) {
                    String[] undoAction = undo.pop().split(" ");
                    if (undoAction[0].equals("add")) {
                        sentence.remove(sentence.size() - 1); // Reverse an add operation
                    } else if (undoAction[0].equals("delete")) {
                        sentence.add(undoAction[1]); // Reverse a delete operation
                    }
                    redo.push(undoAction[0] + " " + undoAction[1]);
                }
            } else if (command == "redo") {
                if (!redo.isEmpty()) {
                    String[] pre = redo.pop().split(" ");
                    if (pre.equals("add")) {
                        sentence.add(pre[1]);
                    } else if (pre[0].equals("delete")) {
                        sentence.remove(sentence.size() - 1);
                    }
        }
            }
        }
    }
}
