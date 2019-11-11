public class Main {
    public static void main(String[] args) {
        Database db = new Database(); // Receiver
        Developer dev = new Developer( // Invoker
                new InsertCommand(db),
                new SelectCommand(db),
                new UpdateCommand(db),
                new DeleteCommand(db)
        );

        dev.insertRecord();
        dev.selectRecord();
        dev.updateRecord();
        dev.deleteRecord();
    }
}

interface Command {
    void execute();
}

class Database {
    public void insertRecord() {
        System.out.println("Inserting data...");
    }

    public void selectRecord() {
        System.out.println("Reading data...");
    }

    public void updateRecord() {
        System.out.println("Updating data...");
    }

    public void deleteRecord() {
        System.out.println("Deleting data...");
    }
}

class InsertCommand implements Command {
    private Database database;

    // parameters if needed

    public InsertCommand(Database database) { // parameters set via constructor
        this.database = database;
    }

    @Override
    public void execute() {
        database.insertRecord();
    }
}

class SelectCommand implements Command {
    private Database database;

    // parameters if needed

    public SelectCommand(Database database) { // parameters set via constructor
        this.database = database;
    }

    @Override
    public void execute() {
        database.selectRecord();
    }
}

class UpdateCommand implements Command {
    private Database database;

    // parameters if needed

    public UpdateCommand(Database database) { // parameters set via constructor
        this.database = database;
    }

    @Override
    public void execute() {
        database.updateRecord();
    }
}

class DeleteCommand implements Command {
    private Database database;

    // parameters if needed

    public DeleteCommand(Database database) { // parameters set via constructor
        this.database = database;
    }

    @Override
    public void execute() {
        database.deleteRecord();
    }
}

class Developer {
    private Command insert;
    private Command select;
    private Command update;
    private Command delete;

    public Developer(Command insert, Command select, Command update, Command delete) {
        this.insert = insert;
        this.select = select;
        this.update = update;
        this.delete = delete;
    }

    public void insertRecord() {
        insert.execute();
    }

    public void updateRecord() {
        update.execute();
    }

    public void selectRecord() {
        select.execute();
    }

    public void deleteRecord() {
        delete.execute();
    }
}
