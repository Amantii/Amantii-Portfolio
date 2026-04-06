CREATE TABLE IF NOT EXISTS experience (
    id               BIGSERIAL PRIMARY KEY,
    company          VARCHAR(100) NOT NULL,
    location         VARCHAR(100),
    role             VARCHAR(100) NOT NULL,
    role_description TEXT[]       NOT NULL,
    start_date       VARCHAR(20)  NOT NULL,
    end_date         VARCHAR(20),
    sort_order       INT          DEFAULT 0
);

INSERT INTO experience (company, location, role, role_description, start_date, end_date, sort_order)
VALUES ('General Motors', 'Roswell, GA', 'Senior Software Engineer', ARRAY[
    'Architected scalable Angular/TypeScript frontends used by thousands of dealership users globally',
    'Built reusable component libraries standardizing UI across multiple enterprise apps',
    'Delivered 300+ production features with zero critical regressions',
    'Migrated legacy platforms to Angular 18, reducing technical debt',
    'Integrated OpenAI APIs to automate repetitive user actions and enhance decision support',
    'Mentored junior engineers and led code reviews enforcing scalable frontend standards',
    'Integrated frontend pipelines into CI/CD workflows, improving deployment reliability'
], 'Mar 2022', NULL, 1),
('General Motors', 'Roswell, GA', 'Software Engineer in Test', ARRAY[
    'Expanded automated test coverage across frontend and API systems',
    'Built scalable UI and integration testing frameworks, reducing regression risk',
    'Shortened release cycles by embedding automated tests into CI/CD pipelines'
], 'May 2021', 'Mar 2022', 2);
