dependencies {
    compileOnly(project(":"))

    // database driver
    compileOnly("org.xerial", "sqlite-jdbc", "3.39.3.0")
    compileOnly("org.postgresql", "postgresql", "42.5.0")
    compileOnly("org.mariadb.jdbc", "mariadb-java-client", "3.0.8")
    compileOnly("mysql", "mysql-connector-java", "8.0.30")
}

publishing {
    publications.clear()
}
