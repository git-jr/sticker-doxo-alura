package enums;

public enum APIEnum {

    IMDB_OFICIAL ("https://imdb-api.com/en/API/Top250Movies/k_12345678"),
    IMDB("https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060"),
    NASA("https://api.nasa.gov/planetary/apod?api_key=nDRteSdfXemKMg6eXVhKFPH36StA21Dr7Ey20QIg&start_date=2022-06-12&end_date=2022-06-14");

    private final String url;

    APIEnum(String url) {
        this.url = url;
    }

    public String url() {
        return url;
    }

}
