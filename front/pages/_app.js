import "bootstrap/dist/css/bootstrap.css"; // Add this line
import "../public/static/styles/style.css";

function MyApp({ Component, pageProps }) {
  return <Component {...pageProps} />;
}

export default MyApp;
