package oop;

public class EmployeeOOP {
    private int employee_id;
    private String name;
    private String title;
    private String modifidate;

    public int getId() {
        return employee_id;
    }
    public void setId(int id) {
        this.employee_id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setModifidate(String modifidate) {
        this.modifidate = modifidate;
    }

    public String getModifidate() {
        return modifidate;
    }
}