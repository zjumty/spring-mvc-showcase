package org.springframework.samples.mvc.fastjson;

import java.util.Date;
import java.util.List;

/**
 * User: matianyi
 * Date: 13-8-18
 * Time: 下午10:27
 */
public class FooBean {
    private String name;

    private Long id;

    private Date birthday;

    private List<Address> addresses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "FooBean{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", birthday=" + birthday +
                ", addresses=" + addresses +
                '}';
    }
}
