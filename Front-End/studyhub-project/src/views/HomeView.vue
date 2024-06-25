<template>
  <div class="about-container">
    <section class="about">
      <div class="content">
        <h1>About Our LMS</h1>
        <p>Welcome to our Learning Management System (LMS), your ultimate platform for online education. Our LMS is designed to provide a seamless and engaging learning experience for students, educators, and institutions.</p>
        
        <h2>Our Mission</h2>
        <p>We aim to revolutionize the way education is delivered by leveraging technology to create a dynamic and interactive learning environment. Our mission is to make education accessible, efficient, and enjoyable for everyone.</p>
        
        <h2>Features</h2>
        <ul>
          <li>Interactive Courses: Engage with multimedia-rich courses designed by experts.</li>
          <li>Personalized Learning: Tailor your learning path to suit your individual needs.</li>
          <li>Progress Tracking: Monitor your progress with our comprehensive tracking tools.</li>
          <li>Community Support: Connect with fellow learners and instructors for support and collaboration.</li>
          <li>Mobile Friendly: Access courses anytime, anywhere with our mobile-friendly design.</li>
        </ul>
        
        <h2>Our Team</h2>
        <p>Our team consists of passionate educators, experienced developers, and dedicated support staff committed to providing the best learning experience possible. We continuously strive to improve and innovate to meet the evolving needs of our users.</p>
        
        <h2>Get In Touch</h2>
        <p>Have questions or need support? <router-link to="/contact">Contact us</router-link> and we'll be happy to assist you!</p>
      </div>
    </section>
  </div>
</template>

<style>
/* General reset for padding and margin */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: Arial, sans-serif;
  background-color: #5eb7b3; /* Light background for the whole container */
}

.about-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh; /* Full height */
  padding: 20px; /* Padding around the content */
}

.about {
  background-color: #ffffff; /* White background for the about section */
  padding: 40px; /* Padding around the about content */
  border-radius: 10px; /* Rounded corners */
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1); /* Light shadow for depth */
  width: 100%;
  max-width: 800px; /* Max width for the about section */
}

h1, h2 {
  color: #087129; /* Darker text color */
  margin-bottom: 20px; /* Space below headings */
}

p {
  color: #000000; /* Medium text color */
  line-height: 1.6; /* Line height for better readability */
  margin-bottom: 20px; /* Space below paragraphs */
}

ul {
  list-style-type: disc; /* Disc style list */
  padding-left: 20px; /* Padding for the list */
  margin-bottom: 20px; /* Space below the list */
}

li {
  margin-bottom: 10px; /* Space below list items */
  color:#000000;
}

@media (min-width: 1024px) {
  .about {
    min-height: 30vh;
    margin-left: 100px;
  }
}
</style>
