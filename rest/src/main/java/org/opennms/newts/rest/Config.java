package org.opennms.newts.rest;


import org.opennms.newts.api.MeasurementRepository;
import org.opennms.newts.cassandra.CassandraMeasurementRepository;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;


public class Config extends AbstractModule {

    @Override
    protected void configure() {

        bind(MeasurementRepository.class).to(CassandraMeasurementRepository.class);

        bind(String.class).annotatedWith(Names.named("cassandraHost")).toInstance("localhost");
        bind(Integer.class).annotatedWith(Names.named("cassandraPort")).toInstance(9042);
        bind(String.class).annotatedWith(Names.named("cassandraKeyspace")).toInstance("newts");

    }

}
