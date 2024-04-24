import { useSearchParams } from "react-router-dom"

const ListPage = () => {
    const [searchParams] = useSearchParams()

    const page = searchParams.get("page") ? parseInt(searchParams.get("page")) : 1
    const size = searchParams.get("size") ? parseInt(searchParams.get("size")) : 10

    return (
        <div className="p-4 w-full bg-white">
            <div className="text-3xl font-extrabold">
                Todo List Page Component { page } --- { size }
            </div>
        </div>
    )
}

export default ListPage