package hiwotab.roboresumeapplication.Models;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Resume {
    @NotNull
    @Min(1)
    @Id
    long id;
    @NotNull
    @NotEmpty(message = "Enter Full Name")
    String fullName;
    @NotNull
    @Email
    @NotEmpty(message = "Enter Email Address")
    String eMailAdd;
    @NotNull
    @NotEmpty(message = "Enter Organization Name")
    String orgName;
    @NotNull
    @DateTimeFormat(pattern = "MM/dd/YYYY")
    @NotEmpty(message = "Enter Start Date")
    String startDate;

    @DateTimeFormat(pattern = "MM/dd/YYYY")
    @NotEmpty(message = "Enter End Date")
    String endDate;

    long workExp;



    public long getWorkExp() {
        return workExp;
    }

    public void setWorkExp(long workExp) {
        this.workExp = workExp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String geteMailAdd() {
        return eMailAdd;
    }

    public void seteMailAdd(String eMailAdd) {
        this.eMailAdd = eMailAdd;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


}
