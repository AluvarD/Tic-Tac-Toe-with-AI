class Employee {

    // write fields
    protected String name;
    protected String email;
    protected Integer experience;
    // write constructor

    public Employee(String name, String email, Integer experience) {
        this.name = name;
        this.email = email;
        this.experience = experience;
    }

    // write getters

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getExperience() {
        return experience;
    }
}

class Developer extends Employee {

    // write fields
    protected String mainLanguage;
    protected String[] skills;

    // write constructor

    public Developer(String name, String email, Integer experience, String mainLanguage, String[] skills) {
        super(name, email, experience);
        this.mainLanguage = mainLanguage;
        this.skills = skills;
    }

    // write getters

    public String getMainLanguage() {
        return mainLanguage;
    }

    public String[] getSkills() {
        return skills;
    }
}

class DataAnalyst extends Employee {

    // write fields
    protected Boolean phd;
    protected String[] methods;

    // write constructor

    public DataAnalyst(String name, String email, Integer experience, Boolean phd, String[] methods) {
        super(name, email, experience);
        this.phd = phd;
        this.methods = methods;
    }

    // write getters

    public Boolean isPhd() {
        return phd;
    }

    public String[] getMethods() {
        return methods;
    }
}