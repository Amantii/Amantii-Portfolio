CREATE TABLE projects (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    github_url VARCHAR(255),
    live_url VARCHAR(255),
    tags TEXT[],
    featured BOOLEAN DEFAULT FALSE,
    sort_order INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE contact_messages (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    sent_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE page_views (
    id BIGSERIAL PRIMARY KEY,
    path VARCHAR(255),
    referrer VARCHAR(255),
    visited_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE experience (
    id BIGSERIAL PRIMARY KEY,
    company VARCHAR(100) NOT NULL,
    location VARCHAR(100),
    role VARCHAR(100) NOT NULL,
    role_description TEXT[],
    start_date VARCHAR(20) NOT NULL,
    end_date VARCHAR(20),
    sort_order INT DEFAULT 0
);