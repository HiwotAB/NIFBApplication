package hiwotab.nifb.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Entity
public class FBPlay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull

    @Min(10)
    @Max(1000)
    private int fbNumber;
    @NotNull
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFbNumber() {
        return fbNumber;
    }

    public void setFbNumber(int fbNumber) {
        this.fbNumber = fbNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<String> runFizzBuzz()
    {
        ArrayList fBO = new ArrayList();

        String fizzBuzzString="";
        for(int i=1; i<=this.getFbNumber(); i++)
        {
            if(i%2==0)
                fizzBuzzString+="Copy";
            if(i%3==0)
                fizzBuzzString+="Fizz";
            if(i%5==0)
                fizzBuzzString+="Buzz";
            if(i%10==0)
                fizzBuzzString+="Cat";
            if(i%2!=0&&i%3!=0&&i%5!=0&&i%10!=0)
                fizzBuzzString=""+i;

            fBO.add(fizzBuzzString);
            fizzBuzzString="";
        }

        return fBO;


    }


}
