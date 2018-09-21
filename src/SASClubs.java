public class SASClubs {
    public Club firstClub;
    public int numClubs;

    public SASClubs() {
        // First Link always starts as null
        firstClub = null;
        numClubs = 0;
    }

    public boolean isEmpty() {
        return (firstClub == null);
    }

    public void insertFirstStudent(String name, String desc, String sp, String pres, Student[] rst) {
        Club link = new Club(name, desc, sp, pres, rst);
        link.next = firstClub;
        firstClub = link;
        numClubs++;
    }

    public Club removeFirst() {
        Club toRemove = firstClub;
        if (isEmpty())
            return null;
        firstClub = firstClub.next;
        numClubs--;
        return toRemove;
    }

    public void displayAll() { //Travel through the LinkedList and output each entry
        Club start = firstClub;
        while (start != null) {
            System.out.print("Name: " + start.getName() + ", Description: " + start.getDescription() + ", Sponsor: "
            + start.getSponsor() + ", President: " + start.getPresident() + ", Roster : ");
            start.getRoster().displayAll();
            start = start.next;
        }
    }

    public Club find(String name) {
        Club toCheck = firstClub;
        if (isEmpty())
            return null;
        while (toCheck.getName() != name) {
            if (toCheck.next == null)
                return null;
            toCheck = toCheck.next;
        }
        return toCheck;
    }

    public Club removeLink(String name) {
        Club current = firstClub;
        Club previous = null;
        while (current.getName() != name) {
            if (current.next == null)
                return null;
            previous = firstClub;
            current = firstClub.next;
        }
        if (current == firstClub) {
            numClubs--;
            return removeFirst();
        }
        previous.next = current.next;
        numClubs--;
        return current;
    }

    public Club[] toArray() {
        Club start = firstClub;
        Club[] clubs = new Club[numClubs];
        for (int i = 0; i < numClubs; i++) {
            clubs[i] = start;
            start = start.next;
        }
        return clubs;
    }
}
