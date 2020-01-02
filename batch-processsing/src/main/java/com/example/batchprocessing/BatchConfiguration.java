package com.example.batchprocessing;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory JobBuilderFactory;

    @Autowired
    public StepBuilderFactory StepBuilderFactory;

    @Bean
    public FlatFileItemReader<Person> reader {
        return new FlatFileItemReaderBuilder<Person>()
            .name("personItemReader")
            .resource(new ClassPathResource("sample-data.csv"))
            .delimited()
            .names(new String[]{"firstName","lastName"})
            .fieldSetMapper(new BeanWrapperFieldSetMapper<Person>) {{
                setTargetType(Person.class);
            }})
            .build();
    }

    @Bean
    public PersonItemProcessor processor() {
        return new PersonItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Person> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Person>()
            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
    }
}
