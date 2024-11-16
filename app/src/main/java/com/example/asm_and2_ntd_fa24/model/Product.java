package com.example.asm_and2_ntd_fa24.model;
public class Product {
    private String tenSP;
    private String giaSP;

    public Product() {
    }
    public Product(String tenSP, String giaSP) {
        this.tenSP = tenSP;
        this.giaSP = giaSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(String giaSP) {
        this.giaSP = giaSP;
    }

    @Override
    public String toString() {
        return "Product{" +
                "tenSP='" + tenSP + '\'' +
                ", giaSP='" + giaSP + '\'' +
                '}';
    }
}
