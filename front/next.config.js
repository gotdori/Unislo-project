/** @type {import('next').NextConfig} */
const nextConfig = {};

// module.exports = {
//   async rewrites() {
//     return [
//       {
//         source: "/:path*",
//         destination: "http://localhost:9000/:path*",
//       },
//     ];
//   },
// };

// module.exports = {
//   env: {
//     SERVER_URL: process.env.SERVER_URL,
//   },
// };
module.exports = nextConfig;

// 스프링부트 컨트롤러에 @CrossOrigin(origins = "http://localhost:3000")를 달아주면 위에 코드 필요 없음
// CORS문제인데 CrossOrigin는 서버로 해결방법이고 nextConfig는 클라이언트 해결
