/*
Скрипт заполняет таблицу все поля в navbar и таблицу About User для /admin и /user
 */
$(async function () {
    await loadUser();
});

async function loadUser() {
    fetch("http://localhost:8088/api/user")
        .then(r => r.json())
        .then(data => {
            $('#navUsername').append(data.email);
            let roles = data.roles.map(role => " " + role.name.substring(5));
            $('#navRoles').append(roles);

            let user = `$(
            <tr>
                <td>${data.id}</td>
                <td>${data.username}</td>
                <td>${data.firstName}</td>
                <td>${data.lastName}</td>
                <td>${data.age}</td>
                <td>${data.email}</td>
                <td>${roles}</td>)`;
            $('#userPanelBody').append(user);
        })
        .catch((error) => {
            alert(error);
        });
}




