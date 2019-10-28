package com.kgc.test.entity;

import java.util.Date;

public class Takeout {
    private Integer id;

    private Integer quantity;

    private Date outdate;

    private String handler;

    private Integer productid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getOutdate() {
        return outdate;
    }

    public void setOutdate(Date outdate) {
        this.outdate = outdate;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    @Override
    public String toString() {
        return "Takeout{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", outdate=" + outdate +
                ", handler='" + handler + '\'' +
                ", productid=" + productid +
                '}';
    }
}