package ru.udya.sharedsession.permission.domain;

public class SharedUserScreenPermission implements SharedUserPermission {

    private static final long serialVersionUID = 3596117407250285500L;

    protected String screenId;

    protected String operation;

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        SharedUserScreenPermission that = (SharedUserScreenPermission) o;

        if (! screenId.equals(that.screenId)) { return false; }
        return operation.equals(that.operation);
    }

    @Override
    public int hashCode() {
        int result = screenId.hashCode();
        result = 31 * result + operation.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SharedUserScreenPermission{" +
               "screenId='" + screenId + '\'' +
               ", operation='" + operation + '\'' +
               '}';
    }
}
