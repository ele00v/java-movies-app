package moviesApp;

class Movie {
    private String code;
    private String title;
    private String year;
    private String duration;
    private String director;
    private String category;
    private String production;
    private String protagonist;
    private String language;
    
    public Movie(){
    }

    public Movie(String code, String title, String year, String duration, String director, String category, String production, String protagonist, String language) {
        this.code = code;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.director = director;
        this.category = category;
        this.production = production;
        this.protagonist = protagonist;
        this.language = language;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getDuration() {
        return duration;
    }

    public String getDirector() {
        return director;
    }

    public String getCategory() {
        return category;
    }

    public String getProduction() {
        return production;
    }

    public String getProtagonist() {
        return protagonist;
    }

    public String getLanguage() {
        return language;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public void setProtagonist(String protagonist) {
        this.protagonist = protagonist;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override 
    public String toString(){
        return code + "\t" + title + "\t" + year + "\t" + duration +"\t" + director + "\t" + 
                category + "\t" + production + "\t" + protagonist + "\t" + language + "\t" ;
    }
}