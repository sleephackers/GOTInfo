package com.example.android.gotinfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("dateOfBirth")
    @Expose
    private long dateOfBirth;
    @SerializedName("imageLink")
    @Expose
    private String imageLink;
    @SerializedName("male")
    @Expose
    private boolean male;
    @SerializedName("spouse")
    @Expose
    private String spouse;
    @SerializedName("house")
    @Expose
    private String house;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("__v")
    @Expose
    private long v;
    @SerializedName("pageRank")
    @Expose
    private long pageRank;
    @SerializedName("hasPath")
    @Expose
    private boolean hasPath;
    @SerializedName("books")
    @Expose
    private List<String> books = null;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("titles")
    @Expose
    private List<String> titles = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Data() {
    }

    /**
     *
     * @param dateOfBirth
     * @param books
     * @param pageRank
     * @param male
     * @param house
     * @param updatedAt
     * @param id
     * @param v
     * @param createdAt
     * @param spouse
     * @param imageLink
     * @param name
     * @param titles
     * @param slug
     * @param hasPath
     */
    public Data(String id, long dateOfBirth, String imageLink, boolean male, String spouse, String house, String slug, String name, long v, long pageRank, boolean hasPath, List<String> books, String updatedAt, String createdAt, List<String> titles) {
        super();
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.imageLink = imageLink;
        this.male = male;
        this.spouse = spouse;
        this.house = house;
        this.slug = slug;
        this.name = name;
        this.v = v;
        this.pageRank = pageRank;
        this.hasPath = hasPath;
        this.books = books;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.titles = titles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Data withId(String id) {
        this.id = id;
        return this;
    }

    public long getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Data withDateOfBirth(long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Data withImageLink(String imageLink) {
        this.imageLink = imageLink;
        return this;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public Data withMale(boolean male) {
        this.male = male;
        return this;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public Data withSpouse(String spouse) {
        this.spouse = spouse;
        return this;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public Data withHouse(String house) {
        this.house = house;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Data withSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data withName(String name) {
        this.name = name;
        return this;
    }

    public long getV() {
        return v;
    }

    public void setV(long v) {
        this.v = v;
    }

    public Data withV(long v) {
        this.v = v;
        return this;
    }

    public long getPageRank() {
        return pageRank;
    }

    public void setPageRank(long pageRank) {
        this.pageRank = pageRank;
    }

    public Data withPageRank(long pageRank) {
        this.pageRank = pageRank;
        return this;
    }

    public boolean isHasPath() {
        return hasPath;
    }

    public void setHasPath(boolean hasPath) {
        this.hasPath = hasPath;
    }

    public Data withHasPath(boolean hasPath) {
        this.hasPath = hasPath;
        return this;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    public Data withBooks(List<String> books) {
        this.books = books;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Data withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Data withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public Data withTitles(List<String> titles) {
        this.titles = titles;
        return this;
    }

}
