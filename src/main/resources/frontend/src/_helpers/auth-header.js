export function authHeader() {
    // return authorization header with jwt token
    let user = JSON.parse(localStorage.getItem('user'));
    // eslint-disable-next-line
    if (user && user.token && user.userDetails.authorities[0].authority == 'ROLE_ADMIN') {
        return { 'Authorization': 'Bearer ' + user.token };
    } else {
        return {};
    }
}