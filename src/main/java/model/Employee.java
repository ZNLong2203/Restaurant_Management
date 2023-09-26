package model;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Objects;

public class Employee {
    @BsonProperty("id")
    @BsonId
    private ObjectId id;

    @BsonProperty("employee_id")
    private int employeeId;
    private String name;
    private String title;
    private String modifidate;

    public Employee() {
    }

    public Employee(ObjectId id, int employee_id, String name, String title, String modifidate) {
        this.id = id;
        this.employeeId = employee_id;
        this.name = name;
        this.title = title;
        this.modifidate = modifidate;
    }

    public ObjectId getId() {
        return id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getModifidate() {
        return modifidate;
    }

    public Employee setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public Employee setEmployeeId(int employee_id) {
        this.employeeId = employee_id;
        return this;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public Employee setTitle(String title) {
        this.title = title;
        return this;
    }

    public Employee setModifidate(String modifidate) {
        this.modifidate = modifidate;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("id=").append(id);
        sb.append(", employee_id=").append(employeeId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", modifidate='").append(modifidate).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(employeeId, employee.employeeId) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(title, employee.title) &&
                Objects.equals(modifidate, employee.modifidate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, name, title, modifidate);
    }
}