public class Roster {
    public Student firstStudent;
    public int numStudents;

    public Roster() {
        // First Link always starts as null
        firstStudent = null;
        numStudents = 0;
    }

    public boolean isEmpty() {
        return (firstStudent == null);
    }

    public void insertFirstStudent(String name, String grade) {
        Student link = new Student(name, grade);
        link.next = firstStudent;
        firstStudent = link;
        numStudents++;
    }

    public Student removeFirst() {
        Student toRemove = firstStudent;
        if (isEmpty())
            return null;
        firstStudent = firstStudent.next;
        numStudents--;
        return toRemove;
    }

    public void displayAll() { //Travel through the LinkedList and output each entry
        Student start = firstStudent;
        while (start != null) {
            System.out.print("Node title: " + start.getName() + ", Node description: " + start.getGrade());
            start = start.next;
        }
    }

    public Student find(String name) {
        Student toCheck = firstStudent;
        if (isEmpty())
            return null;
        while (toCheck.getName() != name) {
            if (toCheck.next == null)
                return null;
            toCheck = toCheck.next;
        }
        return toCheck;
    }

    public Student removeLink(String name) {
        Student current = firstStudent;
        Student previous = null;
        while (current.getName() != name) {
            if (current.next == null)
                return null;
            previous = firstStudent;
            current = firstStudent.next;
        }
        if (current == firstStudent) {
            numStudents--;
            return removeFirst();
        }
        previous.next = current.next;
        numStudents--;
        return current;
    }

    public Student[] toArray() {
        Student start = firstStudent;
        Student[] roster = new Student[numStudents];
        for (int i = 0; i < numStudents; i++) {
            roster[i] = start;
            start = start.next;
        }
        return roster;
    }
}
