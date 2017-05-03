dataSource {
    pooled = true
    driverClassName = "org.postgresql.Driver"
    // dialect = org.hibernate.dialect.PostgreSQLDialect
    dialect = net.sf.hibernate.dialect.PostgreSQLDialect
}
hibernate {
    cache.use_second_level_cache=true
    cache.use_query_cache=true
    cache.provider_class='com.opensymphony.oscache.hibernate.OSCacheProvider'
}
// environment specific settings
environments {
    development {
        dataSource {
            // one of 'create', 'create-drop','update'
            dbCreate = "create-drop"
            url="jdbc:postgresql://localhost:5432/grails"
            username = "postgres"
            password = "tmm1985"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url="jdbc:postgresql://localhost:5432/grails"
            //driverClassName = "org.postgresql.Driver"
            username = "postgres"
            password = "tmm1985"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url="jdbc:postgresql://localhost:5432/grails"
            username = "postgres"
            password = "tmm1985"
        }
    }
}