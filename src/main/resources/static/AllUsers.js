/*
Скрипт заполняет таблицу All Users на вкладке User Table
 */
$(async function () {
    await allUsers();
});

async function allUsers() {
    const table = $('#bodyAllUserTable');
    table.empty()
    fetch("http://localhost:8088/api/admin/")
        .then(r => r.json())
        .then(data => {
            data.forEach(user => {
                let users = `$(
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>                         
                            <td>${user.age}</td>
                            <td>${user.email}</td>
                            <td>${user.roles.map(role => " " + role.name.substring(5))}</td>
                            <td>
                                <button type="button" class="btn btn-info" data-toggle="modal" id="buttonEdit" data-action="edit" data-id="${user.id}" data-target="#edit">Edit</button>
                            </td>
                            <td>
                                <button type="button" class="btn btn-danger" data-toggle="modal" id="buttonDelete" data-action="delete" data-id="${user.id}" data-target="#delete">Delete</button>
                            </td>
                        </tr>)`;
                table.append(users);
            })
        })
        .catch((error) => {
            alert(error);
        })
}
