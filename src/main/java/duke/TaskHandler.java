package duke;

/**
 * Represents the parser to handle commands.
 */
public class TaskHandler {
    private TaskList taskList;
    private Ui ui;
    private Storage storage;

    /**
     * Default constructor for TaskHandler.
     *
     * @param taskList TaskList to edit the list.
     * @param ui Ui to return messages.
     * @param storage Storage folder to store as file.
     */

    public TaskHandler(TaskList taskList, Ui ui, Storage storage) {
        this.taskList = taskList;
        this.ui = ui;
        this.storage = storage;
    }

    /**
     * Method to add an item to the list.
     *
     * @param input Input to be added to the list.
     * @return string message.
     */
    String addTask(String input) {
        return TaskList.add(input, storage);
    }

    /**
     * Method to delete an item from the list.
     *
     * @param input Input to be deleted from the list.
     * @return string message.
     */
    String deleteTask(String input) {
        return TaskList.delete(input, storage);
    }

    /**
     * Method to mark an item in the list.
     *
     * @param input Input to be marked in the list.
     * @return string message.
     */
    public String markChild(String input) {
        int index = Integer.parseInt(input.substring(5)) - 1;
        assert index >= 0 : "index should at least 0";
        return taskList.markChild(index, storage);
    }

    /**
     * Method to unmark an item in the list.
     *
     * @param input Input to be unmarked in the list.
     * @return string message.
     */
    public String unmarkChild(String input) {
        int index = Integer.parseInt(input.substring(7)) - 1;
        assert index >= 0 : "index should at least 0";
        return taskList.unmarkChild(index, storage);
    }

    public String findTask(String input) {
        String formattedInput = input.substring(5);
        return taskList.find(formattedInput);
    }
}
