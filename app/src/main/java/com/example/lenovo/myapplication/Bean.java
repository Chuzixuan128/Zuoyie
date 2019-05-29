package com.example.lenovo.myapplication;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Bean {
@Id(autoincrement = true)
    private Long id;

@Property
    private String name;

@Property
    private String paw;

@Generated(hash = 1898581381)
public Bean(Long id, String name, String paw) {
    this.id = id;
    this.name = name;
    this.paw = paw;
}

@Generated(hash = 80546095)
public Bean() {
}

public Long getId() {
    return this.id;
}

public void setId(Long id) {
    this.id = id;
}

public String getName() {
    return this.name;
}

public void setName(String name) {
    this.name = name;
}

public String getPaw() {
    return this.paw;
}

public void setPaw(String paw) {
    this.paw = paw;
}

}
