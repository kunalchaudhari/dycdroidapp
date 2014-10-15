package echaiventures.designyourcity;

/**
 * Created by Rahul on 15-10-2014.
 */
public class RowItem {
    //private String username;
    private String comment;
    private String currentDate;

    public RowItem(String comment, String currentDate) {
        super();
        this.comment = comment;
        this.currentDate = currentDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

}

